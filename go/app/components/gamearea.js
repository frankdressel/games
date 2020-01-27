import Component from '@glimmer/component';
import { action } from '@ember/object';
import rough from 'roughjs/dist/rough.umd';

export default class GameareaComponent extends Component {
  constructor() {
    super(...arguments);
    this.gap = 10;
    this.height = 0;
    this.spacing = 0;
    this.offsetX = 0;
    this.offsetY = 0;
  }

  @action
  create(element) {
    let svg = element.querySelector('svg');
    const rc = rough.svg(svg);

    this.height = ((element.clientHeight *0.8) + this.gap) / 20 - this.gap;
    this.spacing = this.height + this.gap;
    this.offsetX = (element.clientWidth - 20 *this.spacing + this.gap) / 2;
    this.offsetY = (element.clientHeight- 20 *this.spacing + this.gap) / 2;

    let bordersize = this.spacing * 20 - this.gap;
    for(let i = 0; i < 20; i++) {
      for(let j = 0; j < 20; j++) {
        let node = rc.rectangle(this.offsetX + i * this.spacing, this.offsetY + j * this.spacing, this.height, this.height, {
          stroke: null,
          fill: "rgb(170, 170, 170)",
          fillWeight: 1
        });
        node.setAttributeNS(null, 'id', 'plaquette' + i + '-' + j);
        node.setAttributeNS(null, 'pointer-events', 'none');
        svg.appendChild(node);
      }
    }

    let border = rc.rectangle(this.offsetX, this.offsetY, bordersize, bordersize, {
      fill: null,
      roughness: 0.5,
    });
    border.setAttributeNS(null, 'pointer-events', 'none');
    border.setAttribute('id', 'gameborder');
    svg.appendChild(border);

    let bb = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
    bb.setAttribute('id', 'click_bb');
    bb.setAttributeNS(null, 'x', this.offsetX);
    bb.setAttributeNS(null, 'y', this.offsetY);
    bb.setAttributeNS(null, 'height', bordersize);
    bb.setAttributeNS(null, 'width', bordersize);
    bb.setAttributeNS(null, 'fill', 'none');
    bb.setAttributeNS(null, 'pointer-events', 'all');
    bb.onclick = (evt) => this.click(evt);
    svg.appendChild(bb);

    this.update(element);
  }

  @action
  update(element) {
    let svg = element.querySelector('svg');
    let updateable = svg.querySelectorAll('.updateable');
    for(let u of updateable) {
      u.remove();
    }
    const rc = rough.svg(svg);

    let middleX = this.offsetX + this.spacing * 10 + this.height/2;
    let self = this;
    function draw_flag(black) {
      let factor = black ? 1 : -1;

      let f1 = rc.path('M'+ middleX + ' ' + 2 * self.spacing + ' l ' + (factor * 2 * self.spacing) + ' ' + (- 2 * self.spacing));
      let f2 = document.createElementNS('http://www.w3.org/2000/svg', 'path');
      let base = 'M' + (middleX + factor * 2 * self.spacing) + ' ' + 0 + ' l ' + (factor * self.spacing / 2 + factor * self.spacing * 0.1) + ' ' + (self.spacing / 2 - self.spacing * 0.1) + ' l ' + (factor * self.spacing / 2 - factor * self.spacing * 0.1) + ' ' + (self.spacing / 2 + self.spacing * 0.1) + ' l ' + (- factor * self.spacing / 2) + ' ' + (self.spacing / 2) + ' l '  + (- factor * self.spacing / 2 + factor * self.spacing * 0.1) + ' ' + (- self.spacing / 2 - self.spacing * 0.1) + ' l ' + (- factor * self.spacing / 2 - factor * self.spacing * 0.1) + ' ' + (- self.spacing / 2 + self.spacing * 0.1);
      let base_reversed = 'M' + (middleX + factor * 2 * self.spacing) + ' ' + 0 + ' l ' + (factor * self.spacing / 2 - factor * self.spacing * 0.1) + ' ' + (self.spacing / 2 + self.spacing * 0.1) + ' l ' + (factor * self.spacing / 2 + factor * self.spacing * 0.1) + ' ' + (self.spacing / 2 - self.spacing * 0.1) + ' l ' + (- factor * self.spacing / 2) + ' ' + (self.spacing / 2) + ' l '  + (- factor * self.spacing / 2 - factor * self.spacing * 0.1) + ' ' + (- self.spacing / 2 + self.spacing * 0.1) + ' l ' + (- factor * self.spacing / 2 + factor * self.spacing * 0.1) + ' ' + (- self.spacing / 2 - self.spacing * 0.1);
      f2.setAttributeNS(null, 'd', base);
      f2.setAttributeNS(null, 'fill', black ? 'rgb(70, 70, 70)' : 'rgb(200, 200, 200)');
      f2.setAttributeNS(null, 'stroke', black ? 'rgb(70, 70, 70)' : 'rgb(200, 200, 200)');
      f2.setAttributeNS(null, 'stroke-width', '3');
      let animate = document.createElementNS('http://www.w3.org/2000/svg', 'animate');
      animate.setAttributeNS(null, 'dur', '5s');
      animate.setAttributeNS(null, 'repeatCount', 'indefinite');
      animate.setAttributeNS(null, 'attributeName', 'd');
      animate.setAttributeNS(null, 'values', base_reversed + ';' + base + ';' + base_reversed);

      f1.classList.add('updateable');
      f2.classList.add('updateable');
      f2.setAttributeNS(null, 'id', 'partysign');
      f2.appendChild(animate);
      svg.appendChild(f2);
      svg.appendChild(f1);
    }
    draw_flag(this.args.turn == 'b');

    document.getElementById('partysign').ondblclick = (evt) => {
      this.args.show_config();
    };

    let score_black = document.createElementNS("http://www.w3.org/2000/svg", 'text');
    let txt_black = document.createTextNode('Punkte Schwarz: ' + this.args.score_black);
    score_black.setAttribute('id', 'txt_black');
    score_black.appendChild(txt_black);
    score_black.setAttribute('y', this.offsetY - this.gap);
    score_black.classList.add('updateable');
    svg.appendChild(score_black);
    score_black.setAttribute('x', this.offsetX + this.spacing * 20 - this.gap - score_black.getBBox().width);

    let score_white = document.createElementNS("http://www.w3.org/2000/svg", 'text');
    let txt_white = document.createTextNode('Punkte Weiß: ' + this.args.score_white);
    score_white.setAttribute('id', 'txt_white');
    score_white.appendChild(txt_white);
    score_white.setAttribute('x', this.offsetX);
    score_white.setAttribute('y', this.offsetY - this.gap);
    score_white.classList.add('updateable');
    svg.appendChild(score_white);

    for(let row_index in this.args.grid) {
      for(let cell_index in this.args.grid[row_index]) {
        let node = null;
        let is_white = this.args.grid[row_index][cell_index] == 'w';
        let is_black = this.args.grid[row_index][cell_index] == 'b';
        let color = null;
        if(is_white) {
          color = "rgb(200, 200, 200)";
        }
        if(is_black) {
          color = "rgb(70, 70, 70)";
        }
        if(is_white || is_black) {
          node = rc.circle(this.offsetX + row_index * this.spacing + this.height + this.gap/2, this.offsetY + cell_index * this.spacing + this.height + this.gap/2, this.height, {
            stroke: null,
            fill: color,
            fillStyle: 'solid',
            roughness: 0.5,
            fillWeight: 1
          });
          node.classList.add('updateable');
          svg.appendChild(node);
        }
      }
    }
  }

  click(evt) {
    let bb= evt.target.getBoundingClientRect();
    let x = evt.clientX - bb.left;
    let y = evt.clientY - bb.top;

    let i = Math.floor((x - this.height/2) / this.spacing);
    let j = Math.floor((y - this.height/2) / this.spacing);

    if(i >= 0 && i < 19 && j >= 0 && j < 19) {
      this.args.click(i, j);
    }
  }
}
