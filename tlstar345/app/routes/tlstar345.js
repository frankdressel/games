import Route from '@ember/routing/route';
import EmberObject from '@ember/object';

const Pattern = EmberObject.extend({});

export default Route.extend({
    model(){
        return {
            'stones': [[0, 1, 1, 1, 0], [0, 0, 1, 0, 0], [0, 0, 1, 0, 0]],
            'patterns':[
                Pattern.create({'name': 'T', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length-2; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length-2; colindex++){
                            if(
                                matrix[rowindex][colindex]==1 &&
                                matrix[rowindex][colindex+1]==1 &&
                                matrix[rowindex][colindex+2]==1 &&
                                matrix[rowindex+1][colindex+1]==1 &&
                                matrix[rowindex+2][colindex+1]==1
                            ){
                                found=true;
                            }
                        }
                    }
                    return found && sum==5;
                }}),
                Pattern.create({'name': 'L', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length-2; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length-2; colindex++){
                            if(
                                matrix[rowindex][colindex]==1 &&
                                matrix[rowindex+1][colindex]==1 &&
                                matrix[rowindex+2][colindex]==1 &&
                                matrix[rowindex+2][colindex+1]==1 &&
                                matrix[rowindex+2][colindex+2]==1
                            ){
                                found=true;
                            }
                        }
                    }
                    return found && sum==5;
                }}),
                Pattern.create({'name': 'Sternchen', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length-2; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length-2; colindex++){
                            if(
                                matrix[rowindex][colindex+1]==1 &&
                                matrix[rowindex+1][colindex]==1 &&
                                matrix[rowindex+1][colindex+1]==1 &&
                                matrix[rowindex+1][colindex+2]==1 &&
                                matrix[rowindex+2][colindex+1]==1
                            ){
                                found=true;
                            }
                        }
                    }
                    return found && sum==5;
                }}),
                Pattern.create({'name': '3', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        if(matrix[rowindex].reduce((p, c)=>p+c, 0)==3){
                            found=true;
                        }
                    }
                    return found && sum==3;
                }}),
                Pattern.create({'name': '4', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        if(matrix[rowindex].reduce((p, c)=>p+c, 0)==4){
                            found=true;
                        }
                    }
                    return found && sum==4;
                }}),
                Pattern.create({'name': '5', 'solved': false, 'succes': function(matrix){
                    let sum=0;
                    let found=false;
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        for(let colindex=0;colindex<matrix[rowindex].length; colindex++){
                            if(matrix[rowindex][colindex]==1){
                                sum=sum+1;
                            }
                        }
                    }
                    for(let rowindex=0; rowindex<matrix.length; rowindex++){
                        if(matrix[rowindex].reduce((p, c)=>p+c, 0)==5){
                            found=true;
                        }
                    }
                    return found && sum==5;
                }}),
            ]
        };
    }
});
