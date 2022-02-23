let target = document.querySelector("#dynamic");

function randomString() {
    let stringArr = ["Learn to HTML", "Learn to CSS",
    "Learn to Javascript", "Learn to Python", "Learn to Ruby"];
    // dynamic이라는 id 속성값을 가지고 있는 문서 객체를 target에 할당
    let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];
    let selectStringArr = selectString.split(""); // ['L', 'e', 'a', 'r', 'n', ...]

    return selectStringArr;
}

// 타이핑 리셋
function resetTyping() {
    target.textContent = "";
    dynamic(randomString());
}

function dynamic(randomArr) {
    if (randomArr.length > 0) {
        target.textContent += randomArr.shift();
        setTimeout(function() {
            dynamic(randomArr);
        }, 80);
    } else {
        setTimeout(resetTyping, 3000);
    }
}


dynamic(randomString());

console.log(selectString);
console.log(selectStringArr);

// 커서 깜빡임 효과
function blink() {
    target.classList.toggle("active"); // active 반복
}

setInterval(blink, 500); // 0.5초마다 추가되었다가 삭제 반복
