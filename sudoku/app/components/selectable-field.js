import Component from '@ember/component';

export default Component.extend({
    init() {
        this._super(...arguments);
        if(!Ember.components){
            Ember.components=[];
        }
        let that=this;
        let index=Ember.components.length;
        this.buttonid='button'+index;
        Ember.components.push({setSymbol:function(s){
            that.get('cell').set('symbol', s);
            console.log(s);
            Ember.$('#'+that.buttonid).popover('hide');
        }});
        this.content=this.get('symbols').map(function(s){return '<button class="btn" onClick=Ember.components['+index+'].setSymbol('+s+')>'+s+'</button>';}).reduce(function(p, c){return p+c;});
    },
    didRender(){
        $(document).ready(function(){
            $('[data-toggle="popover"]').popover();
        });
    },
});
