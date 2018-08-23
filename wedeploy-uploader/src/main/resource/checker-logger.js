var lastBotton;
var currentBotton;

function showList(id) {
    if (lastBotton != null) {
        lastBotton.classList.remove('show');
    }

    currentBotton = document.getElementById(id);
    currentBotton.classList.toggle("show");

    lastBotton = currentBotton;
}
