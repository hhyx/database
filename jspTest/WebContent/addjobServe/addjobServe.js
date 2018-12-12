(function(){
    window.onload = function() {
        document.getElementsByName("sub")[0].addEventListener("mouseover", change);
        document.getElementsByName("sub")[0].addEventListener("mouseout", ori);
        document.getElementsByName("sub")[0].addEventListener("click", ori);
        document.getElementsByName("name")[0].addEventListener("focus", bchange);
        document.getElementsByName("salary")[0].addEventListener("focus", schange);
        document.getElementsByName("name")[0].addEventListener("blur", bchangea);
        document.getElementsByName("salary")[0].addEventListener("blur", schangea);
        document.getElementsByName("desciption")[0].addEventListener("focus", dchange);
        document.getElementsByName("desciption")[0].addEventListener("blur", dchangea);
    }

    function change() {
        document.getElementsByName("sub")[0].style.backgroundColor = "#6AA8EE";   
    }

    function ori() {
        document.getElementsByName("sub")[0].style.backgroundColor = "#5A98DE";   
    }

    function bchange() {
        document.getElementsByName("name")[0].style.borderColor = "#565564"
    }

    function schange() {
        document.getElementsByName("salary")[0].style.borderColor = "#565564"
    }

    function bchangea() {
        document.getElementsByName("name")[0].style.borderColor = "#96A5B4"
    }

    function schangea() {
        document.getElementsByName("salary")[0].style.borderColor = "#96A5B4"
    }

    function dchange() {
        document.getElementsByName("desciption")[0].style.borderColor = "#565564"
    }

    function dchangea() {
        document.getElementsByName("desciption")[0].style.borderColor = "#96A5B4"
    }

})();