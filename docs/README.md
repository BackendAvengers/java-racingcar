# 초간단 자동차 경주 게임을 구현한다.

## 자동차
- 자동차는 전진 또는 멈출 수 있다.
  - [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [X] 이름이 있다.
  - [X] 이름은 5자 이하만 가능하다.

## 모든 자동차를 제어하는 역활
- 모든 자동차를 입력받은 횟수 만큼 움직일 수 있다.
- 자동차의 움직인 횟수를 기준으로 정렬할 수 있다.
- 제일 많이 움직인 자동차를 가져올 수 있다.

## 게임의 주체
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 

## 출력
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

## 입력
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- ,를 기준으로 자동차의 이름들을 입력받을 수 있다.
- 자동차를 몇 번 이동시킬 것인지 입력할 수 있다.

JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

Randoms.pickNumberInRange(0,9);