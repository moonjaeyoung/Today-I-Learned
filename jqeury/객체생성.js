let car1 = {};

car1.color = "white";
car1.price = "1000만원";
car1.getInfo1 = function () {
    document.write("생상: ", this.color, "<br>");
    document.write("가격: ", this.price, "<br>");
};

car1.getInfo1();
/* 이렇게도 할수 있고*/


// let car2 = {
//     "color": "white",
//     "price": "1000만원",
//     getInfo2() {
//         document.write("생상: ", this.color, "<br>");
//         document.write("가격: ", this.price, "<br>");
//     }
// };
//  이렇게도 내부에서도 할수 있음.
//  이방식은 약간 클래스같음.
//
// car2.getInfo2();