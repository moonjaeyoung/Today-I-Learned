$(function () {
    $(".btn1").on("click", function () {
        if ($(this).text() === "숨김") {
            $(".text_wrap").slideUp(500, function () {
                $(".btn1").text("노출");
            });
        } else {
            $(".text_wrap").slideDown(500, function () {
                $(".btn1").text("숨김");
            });
        }
    });
});