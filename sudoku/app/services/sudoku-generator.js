import Service from '@ember/service';

export default Service.extend({
    init() {
        this._super(...arguments);
        this.length=9;
        this.symbols=[1, 2, 3, 4, 5, 6, 7, 8, 9];
    },
    nextPossible(grid){
        let next=false;
        for(let i=0;i<grid.length;i=i+1){
            for(let j=0;j<grid[i].length;j=j+1){
                if(grid[i][j]==null){
                    return [i, j];
                }
            }
        }

        return null;
    },
    // Taken from: https://stackoverflow.com/a/12646864
    shuffledArray(array) {
        let newAr=array.slice();
        for (let i = newAr.length - 1; i > 0; i--) {
            let j = Math.floor(Math.random() * (i + 1));
            [newAr[i], newAr[j]] = [newAr[j], newAr[i]];
        }
        return newAr;
    },
    next(grid, branch, stop){
        let np=this.nextPossible(grid);
        let i=np[0];
        let j=np[1];

        let results=[];
        
        let randomOrderedSymbols=this.shuffledArray(this.symbols.slice());
        for(let p of randomOrderedSymbols){
            let n=new Array(9);
            for(let i=0;i<this.length;i++){
                n[i]=[null, null, null, null, null, null, null, null, null];
            }
            for(let id=0;id<n.length;id=id+1){
                for(let jd=0;jd<n[id].length;jd=jd+1){
                    n[id][jd]=grid[id][jd]
                }
            }
            n[i][j]=p;

            if(this.solved(n) && this.testColumn(n, i) && this.testRow(n, j) && this.testBox(n, i, j)){
                results.push(n);
                if(stop && results.length>0){
                    return results;
                }
            }
            else{
                if(this.testColumn(n, i) && this.testRow(n, j) && this.testBox(n, i, j)){
                    results=results.concat(this.next(n, branch+1, stop));
                    if(stop && results.length>0){
                        return results;
                    }
                }
                else{
                    continue;
                }
            }
        }

        return results;
    },
    copy(grid){
        let n=new Array(9);
        for(let i=0;i<this.length;i++){
            n[i]=[null, null, null, null, null, null, null, null, null];
        }
        for(let id=0;id<n.length;id=id+1){
            for(let jd=0;jd<n[id].length;jd=jd+1){
                n[id][jd]=grid[id][jd]
            }
        }
        return n;
    },
    generate(){
        let grid=new Array(9);
        for(let i=0;i<this.length;i++){
            grid[i]=[null, null, null, null, null, null, null, null, null];
        }

        let full=this.next(grid, 0, true)[0];
        console.log(full);

        return full;
    },
    puzzle(grid, diffscore){
        
        let puzzle=this.copy(grid);
        let counterNoResult=0;

        while(true){
            let i=Math.floor(Math.random()*this.length);
            let j=Math.floor(Math.random()*this.length);

            let n=this.copy(puzzle);
            n[i][j]=null;
            
            let result=this.next(n, 0, false);
            let num=result.length;
            
            if(num>1){
                break;
            }
            if(num==1){
                puzzle=this.copy(n);
            }
            if(num==0){
                if(counterNoResult>=100){
                    puzzle=this.copy(grid);
                    counterNoResult=0;
                }
                else{
                    counterNoResult=counterNoResult+1;
                    continue;
                }
            }
        } 

        return puzzle;
    },
    solved(grid){
        return grid.reduce(function(previous, row){return previous+row.reduce(function(p, cell){return p+(cell==null?0:1)}, 0)}, 0)==81;
    },
    testBox(grid, i, j){
        let startI=Math.floor(i/3)*3;
        let endI=startI+3;
        let startJ=Math.floor(j/3)*3;
        let endJ=startJ+3;

        let s=new Set();
        let l=[];
        for(let iDash=startI;iDash<endI;iDash++){
            for(let jDash=startJ;jDash<endJ;jDash++){
                let g=grid[iDash][jDash];
                if(g!=null){
                    l.push(g);
                    s.add(g);
                }
            }
        }

        if(s.size!=l.length){
            return false;
        }
        return true;
    },
    testColumn(grid, i){
        let l=grid[i].filter(function(e){return e!=null;});
        let s=new Set(l);
        if(s.size!=l.length){
            return false;
        }
        return true;
    },
    testRow(grid, j){
        let l=grid.reduce(function(prev, e){prev.push(e[j]); return prev;}, []).filter(function(e){return e!=null;});
        let s=new Set(l);
        if(s.size!=l.length){
            return false;
        }
        return true;
    }
});
