$(function () {

    let count = 0;

    $(".btn1")
        .text("움직이기")
        .on("click", function () {
            const txt = $(".text_wrap");
            count++;
            if (count < 10) {
                txt.animate({
                    marginTop: "+=10%"
                }, 500);
            } else {
                txt.animate({
                    marginTop: "15px"
                }, 1500);
                count = 0;
            }
        });

    $(".text_wrap").css({
        border: "1px black solid",
        marginTop: "15px"
    });
});
