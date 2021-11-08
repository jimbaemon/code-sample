var plays = {
    "hamlet": {"명": "Hamlet", "종류": "비극"},
    "as-like": {"명": "As You Like it", "종류": "희극"},
    "othello": {"명": "Othello", "종류": "비극"}
};

var 청구서 = {
    "고객명": "BigCo",
    "상영내역":[
        {
            "연극ID": "hamlet",
            "관객": 55
        },
        {
            "연극ID": "as-like",
            "관객": 35
        },
        {
            "연극ID": "othello",
            "관객": 40
        }
    ]
};

function 연극정보(청구서, 연극내역){
    let 총가격 = 0;
    let 포인트 = 0;
    let result = `청구 내역 (고객명: ${청구서.회원명})\n`;
    const format = new Intl.NumberFormat("en-US", 
    {
        style : "currency", currency: "USD",
        minimumFractionDigits: 2
    }).format;

    for(let 상영 of 청구서.상영내역){
        const 연극 = 연극내역[상영.연극ID];
        let 가격 = 0;

        switch(연극.종류){
            case "비극":
                가격 = 40000;
                if(상영.관객 > 30){
                    가격 += 1000 * (상영.관객 - 30)
                }
                break;
            case "희극":
                가격 = 30000;
                if(상영.관객 > 20){
                    가격 += 10000 + 500 * (상영.관객 - 20);
                }
                가격 += 300 * 상영.관객;
                break;
            default:
                throw new Error('알수 없는 장르: ${연극.종류}');
        }

        포인트 += Math.max(상영.관객 - 30, 0);

        if("희극" === 연극.종류) 포인트 += Math.floor(상영.관객 / 5);
        result += `  ${연극.명}: ${format(가격/100)} (${상영.관객}석)\n`;
        총가격 += 가격;
    }

    result += `총액: ${format(총가격/100)}\n`;
    result += `적립 포인트: ${포인트}점\n`;
    return result;
}