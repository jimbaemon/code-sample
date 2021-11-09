const testResult = '청구 내역 (고객명: BigCo)\n  Hamlet: $650.00 (55석)\n  As You Like it: $580.00 (35석)\n  Othello: $500.00 (40석)\n총액: $1,730.00\n적립 포인트: 40점\n';

function 테스트(){
    const result = 비용책정(청구서, 연극종류);

    if(result === testResult){
        console.log("초록불");
        return;
    }

    console.log("빨간불");
}