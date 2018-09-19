$(function () {

    $.ajax({
        url: "MOCK_DATA.json",
        dataType: "json",
        success: function (data) {
            document.write(data);
        },
        error: function () {
            document.write("에러 발생")
        }
    });
});
//ajax 기본형
