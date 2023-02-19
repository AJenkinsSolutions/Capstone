function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}
function buttonVisibility(scrollBtn){
    if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
        scrollBtn.style.display = "block";
    } else {
        scrollBtn.style.display = "none";
    }
}
window.addEventListener('DOMContentLoaded', ()=>{

    const scrollToTopBtn = document.getElementById("scrollToTopBtn");
    window.onscroll = function (){
        buttonVisibility(scrollToTopBtn)
    }
    scrollToTopBtn.addEventListener("click", scrollToTop);
})
