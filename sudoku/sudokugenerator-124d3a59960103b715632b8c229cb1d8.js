addEventListener("message",function(l){let e=9,n=[1,2,3,4,5,6,7,8,9]
function t(l,u,r){let c=function(l){for(let e=0;e<l.length;e+=1)for(let n=0;n<l[e].length;n+=1)if(null==l[e][n])return[e,n]
return null}(l),h=c[0],s=c[1],g=[],d=function(l){let e=l.slice()
for(let n=e.length-1;n>0;n--){let l=Math.floor(Math.random()*(n+1));[e[n],e[l]]=[e[l],e[n]]}return e}(n.slice())
for(let n of d){let c=new Array(9)
for(let l=0;l<e;l++)c[l]=[null,null,null,null,null,null,null,null,null]
for(let e=0;e<c.length;e+=1)for(let n=0;n<c[e].length;n+=1)c[e][n]=l[e][n]
if(c[h][s]=n,f(c)&&i(c,h)&&a(c,s)&&o(c,h,s)){if(g.push(c),r&&g.length>0)return g
if(!r&&g.length>1)return g}else{if(!(i(c,h)&&a(c,s)&&o(c,h,s)))continue
if(g=g.concat(t(c,u+1,r)),r&&g.length>0)return g
if(!r&&g.length>1)return g}}return g}function u(l){let n=new Array(9)
for(let t=0;t<e;t++)n[t]=[null,null,null,null,null,null,null,null,null]
for(let e=0;e<n.length;e+=1)for(let t=0;t<n[e].length;t+=1)n[e][t]=l[e][t]
return n}function r(l){let e=u(l),t=1
for(let u=0;u<e.length;u++)for(let l=0;l<e[u].length;l++)if(null==e[u][l]){let r=0
for(let t of n)e[u][l]=t,o(e,u,l)&&i(e,u)&&a(e,l)&&(r+=1)
e[u][l]=null,t*=r}return Math.log(t)}function f(l){return 81==l.reduce(function(l,e){return l+e.reduce(function(l,e){return l+(null==e?0:1)},0)},0)}function o(l,e,n){let t=3*Math.floor(e/3),u=t+3,r=3*Math.floor(n/3),f=r+3,o=new Set,i=[]
for(let a=t;a<u;a++)for(let e=r;e<f;e++){let n=l[a][e]
null!=n&&(i.push(n),o.add(n))}return o.size==i.length}function i(l,e){let n=l[e].filter(function(l){return null!=l})
return new Set(n).size==n.length}function a(l,e){let n=l.reduce(function(l,n){return l.push(n[e]),l},[]).filter(function(l){return null!=l})
return new Set(n).size==n.length}if("puzzle"==l.data.cmd){let n=l.data,f=function(l,n){let f=u(l),o=0,i=0
for(;i<1e6;){i++
let a=Math.floor(Math.random()*e),c=Math.floor(Math.random()*e),h=u(f)
h[a][c]=null
let s=t(h,0,!1).length
if(r(h)>n)break
if(s>1)f=u(l)
else if(1==s&&(f=u(h)),0==s){if(!(o>=1e7)){o+=1
continue}f=u(l),o=0}}return f}(function(){let l=new Array(9)
for(let n=0;n<e;n++)l[n]=[null,null,null,null,null,null,null,null,null]
return t(l,0,!0)[0]}(),n.diffscore)
postMessage(f),self.close()}if("check"==l.data.cmd){let e=f(l.data.puzzle)
for(let n=0;n<l.data.puzzle.length;n++){e=e&&i(l.data.puzzle,n)
for(let t=0;t<l.data.puzzle[n].length&&(e=(e=e&&a(l.data.puzzle,t))&&o(l.data.puzzle,n,t));t++);}postMessage(e),self.close()}})
