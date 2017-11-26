
function doOnClick() {
    window.JSToJava.jsCall("JS says hello to Java")
}

function jsAdd(a, b) {
    alert("Java to JS: jsAdd called");
    var sum = a + b;
    return sum;
}
