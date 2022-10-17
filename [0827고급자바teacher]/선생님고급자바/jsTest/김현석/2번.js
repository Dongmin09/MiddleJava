// 랜덤수 생성하는 함수
function getMinMaxRandom(min, max){
    return Math.floor(Math.random()* (max-min) + min + 1);
}

var arr = new Array();

for(var i=0;i<20;i++){ //배열 초기화
    arr[i]=getMinMaxRandom(1,20);
}
console.log(arr);

var minValue = 20;
function getOrderDesc(arr){
    for(var i=0; i<arr.length; i++){
        var currentNumber = arr[i];
        if(minValue > currentNumber){
            minValue = currentNumber;
        }
    }
    return minValue;
}
console.log(getOrderDesc(arr));

