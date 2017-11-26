
function doOnClick() {
    window.JSToJava.someJavaFunction("JSToJava: JS is calling Java")
    alert("alert: JS is calling Java");
}

function jsAdd(a, b) {
    var sum = a + b;
    return sum;
}
