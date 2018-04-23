import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        if(!Ember.components){
            Ember.components=[];
        }
        let that=this;
        Ember.components['selectable-field']={setSymbol:function(s){
            that.get('cell').set('symbol', s);
            console.log(s);
        }};
        this.content=this.get('symbols').map(function(s){return '<button class="btn" onClick=Ember.components["selectable-field"].setSymbol('+s+')>'+s+'</button>';}).reduce(function(p, c){return p+c;});
    },
    didRender(){
        $(document).ready(function(){
            $('[data-toggle="popover"]').popover();
        });
    },
});
