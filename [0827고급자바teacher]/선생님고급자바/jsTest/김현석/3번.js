/* CSS 내용
display : 웹 브라우저의 화면을 나타내준다 
    display:none 영역이 아예 사라짐
    visibility:hidden UI에서 사라지지만 존재하는 영역
position : 각 속성들의 위치를 나타내줌
    1.static: 웹사이트 기본 속성값 , top right bottom left 등 위치 속성은 무시됨.
    2. relative: HTML태그가 있는 위치에서 left right top bottom값을 통해 움직임 
    3. absolute: 부모영역에서  left right top bottom 을 이용해 주어진 위치로 움직임 
    4. fixed : absolute와 비슷하지만 스크롤로 내려도 그 위치에 고정, 무조건 브라우저 창 기준임
    5. Sticky : relative와 비슷하지만 스크롤로 내리면 fixed처럼 그 위치에 고정 
overflow : CSS의  overflow 프로퍼티는 요소내의 컨텐츠가 너무 커서 요소내에 모두 보여주기 힘들때 그것을 어떻게 보여줄지를 지정합니다
    1. visible : 기본값입니다. 넘칠 경우 컨텐츠가 상자 밖으로 보여집니다.
    2. hidden : 넘치는 부분은 잘려서 보여지지 않습니다.
    3. scroll : 스크롤바가 추가되어 스크롤할 수 있습니다.(가로, 세로 모두 추가 됩니다.)
    4. auto : 컨텐츠 량에 따라 스크롤바를 추가할지 자동으로 결정됩니다.( 필요에 따라 가로, 세로 별도로 추가될 수도 있습니다.)
z-index :  z-index는 position 속성이 설정된 엘리먼트에 대해서만 의미를 갖는다.
z-index 속성은 하나의 정수 값을 가질 수 있다(양수, 음수 모두 가능하다). 이 값은 해당 엘리먼트의 z축 상의 위치를 나타낸다. 
        만약 당신이 z축에 익숙하지 않다면 여러 레이어가 쌓여있는 페이지를 상상해보라. 
        각 레이어는 번호가 붙어있고 높은 번호를 가진 레이어는 낮은 번호를 가진 레이어 위에 렌더링된다.
transform : transform 속성을 사용하여 효과를 주고 transition 속성으로 효과를 제어한다.
    효과에는 4가지가 있다.
    1. transform : rotate(angle)
       transform : rotateX(angle)
       transform : rotateY(angle)
       anlge에 각의 크기를 입력 단위는 deg,rad,grad,turn등을 사용
       turn은 1회전 , 즉 360deg를 의미한다
    2. transform: translateX(50px)
      -transform: translateY(50px)
      -transform: translate(50px, 50%)

       X축으로 50픽셀 이동 음수는 반대로 이동
       Y축으로 50픽셀 이동 음수는 반대로 이동
       오른쪽으로 50픽셀, 아래쪽으로 50% 이동

    3. transform: scale(2.0);
      -transform: scale(2.0, 1.5);
      -transform: scaleX(2.0);
      -transform: scaleY(1.5);

      가로와세로 모두 2배 확대
      가로로2배, 세로로1.5배 확대
      가로로 2배 확대
      세로로 1.5배 확대

    4. tansform: skewX(30deg);
      -tansform: skewY(30deg);
      -tansform: skewX(30deg, 60deg);

      가로 방향으로 30도 비틈
      세로 방향으로 30도 비틈
      가로방향 30도 세로방향 60도 비틈
 */