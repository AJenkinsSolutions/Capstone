

window.addEventListener('DOMContentLoaded', () => {


    function toggleDarkMode(){
        const htmlTag = document.querySelector('html');
        const currentTheme = htmlTag.getAttribute('data-bs-theme');
        //   console.log(currentTheme);
        let newTheme = ""
        if(currentTheme === "light"){
            newTheme = "dark"
        }else{
            newTheme = "light"
        }
        htmlTag.setAttribute("data-bs-theme", newTheme);
        return newTheme;
    }

    const darkModeToggle = document.getElementById('dark-mode-button');

    darkModeToggle.addEventListener("click", function(){
        //get current theme
        const htmlTag = document.querySelector('html');
        const currentTheme = htmlTag.getAttribute('data-bs-theme');
        const font = darkModeToggle.firstChild;
        //Flip  theme switch
        if(currentTheme === 'light'){
            font.className = "fa-solid fa-moon";
        }else{
            font.className = "fa-sharp fa-solid fa-sun";
        }
        toggleDarkMode();
    })

})