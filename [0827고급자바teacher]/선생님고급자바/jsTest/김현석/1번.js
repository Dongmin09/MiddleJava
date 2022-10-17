// 시간을 매개변수로 받아서 올라간 거리를 리턴하는 함수

// 시간 1 
function distance(secondTime){   // 거리 리턴
    var sum = 3;
    for(var i=1; i<secondTime; i++){
        if(i%2 != 0 ){ // 
            // 홀수일 경우 2씩 감소
            sum -= 2;
        } else {
            // 짝수일 경우 3씩 증가
            sum += 3;
        }
    }
    return sum+"cm를 올라갔습니다.";
}
console.log(distance(10));

// 거리를 매개변수로 받아서, 그 만큼 올라가는데 걸리는 시간을 리턴하는 함수
function requireTime(distance){    // 시간 리턴
    var sum = -1;
    for(var i=3; i<=distance; i++){
            // 거리가 3 , 4 , 5, ...
            sum += 2;
        if(i==1 || i==2) {
            sum = i*2;
        } 
    }
    return sum + "초 시간이 걸립니다";
}

console.log(distance(3));     // 3초 동안 올라간 거리
console.log(requireTime(4)); // 10cm 올라 가는데 걸리는 초