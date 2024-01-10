let target = document.querySelector("#dynamic");

function randomStr() {
    let strArr = ["Don't sell salt", "Salt is boba", "Salt is cute", "Salt is a crybaby", "Salt loves ggogi"];
    let selectString = strArr[Math.floor(Math.random() * strArr.length)];
    let selectStrArr = selectString.split("");

    return selectStrArr;
}

// 타이핑 리셋
function resetTyping() {
    target.textContent = "";
    dynamic(randomStr());
}

// 한글자씩 텍스트 출력 함수
function dynamic(randomArr) {
    if(randomArr.length > 0) {
        target.textContent += randomArr.shift();
        setTimeout(function() {
            dynamic(randomArr);
        }, 80);
    } else {
        setTimeout(resetTyping, 3000);
    }
}

dynamic(randomStr());

// 커서 깜박임 효과
function blink() {
    target.classList.toggle("active");
}

setInterval(blink, 500);