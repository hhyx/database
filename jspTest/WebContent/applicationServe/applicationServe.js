(function(){
    window.onload = function() {
        document.getElementsByName("sub")[0].addEventListener("mouseover", change);
        document.getElementsByName("sub")[0].addEventListener("mouseout", ori);
        document.getElementsByName("sub")[0].addEventListener("click", ori);
        document.getElementsByName("address")[0].addEventListener("focus", bchange);
        document.getElementsByName("time")[0].addEventListener("focus", schange);
        document.getElementsByName("address")[0].addEventListener("blur", bchangea);
        document.getElementsByName("time")[0].addEventListener("blur", schangea);
    }

    function change() {
        document.getElementsByName("sub")[0].style.backgroundColor = "#6AA8EE";   
    }

    function ori() {
        document.getElementsByName("sub")[0].style.backgroundColor = "#5A98DE";   
    }

    function bchange() {
        document.getElementsByName("address")[0].style.borderColor = "#565564"
    }

    function schange() {
        document.getElementsByName("time")[0].style.borderColor = "#565564"
    }

    function bchangea() {
        document.getElementsByName("address")[0].style.borderColor = "#96A5B4"
    }

    function schangea() {
        document.getElementsByName("time")[0].style.borderColor = "#96A5B4"
    }

})();