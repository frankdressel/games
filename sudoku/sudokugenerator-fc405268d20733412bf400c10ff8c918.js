addEventListener("message",function(l){let n=9,e=[1,2,3,4,5,6,7,8,9]
function t(l,u,r){let h=function(l){for(let n=0;n<l.length;n+=1)for(let e=0;e<l[n].length;e+=1)if(null==l[n][e])return[n,e]
return null}(l),a=h[0],s=h[1],g=[],d=function(l){let n=l.slice()
for(let e=n.length-1;e>0;e--){let l=Math.floor(Math.random()*(e+1));[n[e],n[l]]=[n[l],n[e]]}return n}(e.slice())
for(let e of d){let h=new Array(9)
for(let l=0;l<n;l++)h[l]=[null,null,null,null,null,null,null,null,null]
for(let n=0;n<h.length;n+=1)for(let e=0;e<h[n].length;e+=1)h[n][e]=l[n][e]
if(h[a][s]=e,f(h)&&i(h,a)&&c(h,s)&&o(h,a,s)){if(g.push(h),r&&g.length>0)return g}else{if(!(i(h,a)&&c(h,s)&&o(h,a,s)))continue
if(g=g.concat(t(h,u+1,r)),r&&g.length>0)return g}}return g}function u(l){let e=new Array(9)
for(let t=0;t<n;t++)e[t]=[null,null,null,null,null,null,null,null,null]
for(let n=0;n<e.length;n+=1)for(let t=0;t<e[n].length;t+=1)e[n][t]=l[n][t]
return e}function r(l){let n=u(l),t=1
for(let u=0;u<n.length;u++)for(let l=0;l<n[u].length;l++)if(null==n[u][l]){let r=0
for(let t of e)n[u][l]=t,o(n,u,l)&&i(n,u)&&c(n,l)&&(r+=1)
n[u][l]=null,t*=r}return Math.log(t)}function f(l){return 81==l.reduce(function(l,n){return l+n.reduce(function(l,n){return l+(null==n?0:1)},0)},0)}function o(l,n,e){let t=3*Math.floor(n/3),u=t+3,r=3*Math.floor(e/3),f=r+3,o=new Set,i=[]
for(let c=t;c<u;c++)for(let n=r;n<f;n++){let e=l[c][n]
null!=e&&(i.push(e),o.add(e))}return o.size==i.length}function i(l,n){let e=l[n].filter(function(l){return null!=l})
return new Set(e).size==e.length}function c(l,n){let e=l.reduce(function(l,e){return l.push(e[n]),l},[]).filter(function(l){return null!=l})
return new Set(e).size==e.length}let h=l.data,a=function(l,e){let f=u(l),o=0,i=0
for(;i<1e6;){i++
let c=Math.floor(Math.random()*n),h=Math.floor(Math.random()*n),a=u(f)
a[c][h]=null
let s=t(a,0,!1).length
if(r(a)>e)break
if(s>1)f=u(l)
else if(1==s&&(f=u(a)),0==s){if(!(o>=1e7)){o+=1
continue}f=u(l),o=0}}return f}(function(){let l=new Array(9)
for(let e=0;e<n;e++)l[e]=[null,null,null,null,null,null,null,null,null]
return t(l,0,!0)[0]}(),h.diffscore)
postMessage(a),self.close()})
