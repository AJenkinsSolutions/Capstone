console.log("main.js")
    document.addEventListener("DOMContentLoaded", () =>{
        const loaderWrapper= document.getElementById("loader-wrapper");
        const loader = document.getElementById("loader");

    console.log(loaderWrapper);
    console.log(loader)

    loader.style.display = "none";

    });

    document.addEventListener("click", function(event) {
    if (event.target.tagName.toLowerCase() === "a") {
    document.getElementById("loader").style.display = "block";
}
});

    document.addEventListener("readystatechange", function() {

        if (document.readyState === "complete") {
            document.getElementById("loader").style.display = "none";
}
});
