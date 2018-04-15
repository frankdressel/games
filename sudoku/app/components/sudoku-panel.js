import Component from '@ember/component';

export default Component.extend({
    init(){
        this._super(...arguments);
    },
    willRender(){
        let model=this.get("model");
        this.get("blocks").clear();
        for(let i=0;i<model.length/3;i++){
            for(let j=0;j<model[i].length/3;j++){
                let block=[]
                for(let i2=i*3;i2<i*3+3;i2++){
                    for(let j2=j*3;j2<j*3+3;j2++){
                        block.push(model[i2][j2]);
                    }
                }
                this.get("blocks").push(block);
            }
        }
    },
    blocks: []
});