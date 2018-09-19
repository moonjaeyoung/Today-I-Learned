$(function () {
    $(".wrap_1").css("border", "1px solid orange");
    $(".text").css("background-color", "aqua");
    // 직접 선택자

    $(".wrap_1 p").eq(2).css("background-color", "yellow");
    // 위치 선택자

    $("input[type=text]").css({
        "background-color": "orange"
    });
    //속성 선택자
    //여러개의 속성을 주려면 객체형으로 (파이썬 딕셔너리식으로)
    let num = prompt("숫자를 입력하세요.");

    if (num > 5) {
        $("input[type=text]").remove();
        if (num > 100) {
            $(".wrap_1").removeClass("text");
        }
    }else {
        $(".wrap_1 p").append("<p>텍스트2</p>")
    }
});
