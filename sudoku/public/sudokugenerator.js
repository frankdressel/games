addEventListener('message', function(e) {
    let length=9;
    let symbols=[1, 2, 3, 4, 5, 6, 7, 8, 9];
    function nextPossible(grid){
        let next=false;
        for(let i=0;i<grid.length;i=i+1){
            for(let j=0;j<grid[i].length;j=j+1){
                if(grid[i][j]==null){
                    return [i, j];
                }
            }
        }

        return null;
    };
    // Taken from: https://stackoverflow.com/a/12646864
    function shuffledArray(array) {
        let newAr=array.slice();
        for (let i = newAr.length - 1; i > 0; i--) {
            let j = Math.floor(Math.random() * (i + 1));
            [newAr[i], newAr[j]] = [newAr[j], newAr[i]];
        }
        return newAr;
    };
    function next(grid, branch, stop){
        let np=nextPossible(grid);
        let i=np[0];
        let j=np[1];

        let results=[];
        
        let randomOrderedSymbols=shuffledArray(symbols.slice());
        for(let p of randomOrderedSymbols){
            let n=new Array(9);
            for(let i=0;i<length;i++){
                n[i]=[null, null, null, null, null, null, null, null, null];
            }
            for(let id=0;id<n.length;id=id+1){
                for(let jd=0;jd<n[id].length;jd=jd+1){
                    n[id][jd]=grid[id][jd]
                }
            }
            n[i][j]=p;

            if(solved(n) && testColumn(n, i) && testRow(n, j) && testBox(n, i, j)){
                results.push(n);
                if(stop && results.length>0){
                    return results;
                }
            }
            else{
                if(testColumn(n, i) && testRow(n, j) && testBox(n, i, j)){
                    results=results.concat(next(n, branch+1, stop));
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
    };
    function copy(grid){
        let n=new Array(9);
        for(let i=0;i<length;i++){
            n[i]=[null, null, null, null, null, null, null, null, null];
        }
        for(let id=0;id<n.length;id=id+1){
            for(let jd=0;jd<n[id].length;jd=jd+1){
                n[id][jd]=grid[id][jd]
            }
        }
        return n;
    };
    function difficulty(grid){
        let n=copy(grid);
        let diffscore=1;
        for(let i=0;i<n.length;i++){
            for(let j=0;j<n[i].length;j++){
                if(n[i][j]==null){
                    let num=0;
                    for(let s of symbols){
                        n[i][j]=s;
                        if(testBox(n, i, j) && testColumn(n, i) && testRow(n, j)){
                            num=num+1;
                        }
                    }
                    n[i][j]=null;
                    diffscore=diffscore*num;
                }
            }
        }

        return Math.log(diffscore);
    };
    function generate(){
        let grid=new Array(9);
        for(let i=0;i<length;i++){
            grid[i]=[null, null, null, null, null, null, null, null, null];
        }

        let full=next(grid, 0, true)[0];

        return full;
    };
    function puzzle(grid, diffscore){
        
        let puzzle=copy(grid);
        let counterNoResult=0;
        let counterWhiles=0;

        while(counterWhiles<1000000){
            counterWhiles++;
            let i=Math.floor(Math.random()*length);
            let j=Math.floor(Math.random()*length);

            let n=copy(puzzle);
            n[i][j]=null;
            
            let result=next(n, 0, false);
            let num=result.length;
            
            let ds=difficulty(n);
            if(ds>diffscore){
                break;
            }
            if(num>1){
                puzzle=copy(grid);
                continue;
            }
            if(num==1){
                puzzle=copy(n);
            }
            if(num==0){
                if(counterNoResult>=10000000){
                    puzzle=copy(grid);
                    counterNoResult=0;
                }
                else{
                    counterNoResult=counterNoResult+1;
                    continue;
                }
            }
        } 

        return puzzle;
    };
    function solved(grid){
        return grid.reduce(function(previous, row){return previous+row.reduce(function(p, cell){return p+(cell==null?0:1)}, 0)}, 0)==81;
    };
    function testBox(grid, i, j){
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
    };
    function testColumn(grid, i){
        let l=grid[i].filter(function(e){return e!=null;});
        let s=new Set(l);
        if(s.size!=l.length){
            return false;
        }
        return true;
    };
    function testRow(grid, j){
        let l=grid.reduce(function(prev, e){prev.push(e[j]); return prev;}, []).filter(function(e){return e!=null;});
        let s=new Set(l);
        if(s.size!=l.length){
            return false;
        }
        return true;
    };

    let data=e.data;
    let fullSudoku=generate();
    let result=puzzle(fullSudoku, data.diffscore);

    postMessage(result);
    self.close();
});
