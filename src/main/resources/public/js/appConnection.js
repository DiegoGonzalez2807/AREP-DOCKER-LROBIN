
function insertChain(){
    //var URL_API = "https://serene-bastion-37080.herokuapp.com/search/"+APIRedirect+"/"+document.getElementById("empresa").value;
    var URL_API = "/insert/"+document.getElementById("cadena").value;
    axios.get(URL_API)
        .then(function(res){
        console.log("FUNCIONAL")
        console.log(res.data)
        printingInformation(res.data)
        })
        .catch(function (error) {
            console.log(error)
        })
}

function printingInformation(info){
    div = document.getElementById("allInfo");
    div.innerHTML = JSON.stringify(info,null,2);

}