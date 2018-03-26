/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
    $("#btnArticulo").button().on("click", function ()
    {
        $("#contenido").load("Articulo.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
    $("#btnAutor").button().on("click", function ()
    {
        $("#contenido").load("autor.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
    $("#btnEditorial").button().on("click", function ()
    {
        $("#contenido").load("editorial.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
    $("#btnUsuarios").button().on("click", function ()
    {
        $("#contenido").load("home.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
     $("#btnCatalogos").button().on("click", function ()
    {
        $("#contenido").load("CargarCatalogo.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
     $("#btnCategoria").button().on("click", function ()
    {
        $("#contenido").load("categoria.htm", function (response, status, xhr) {
            if (status === "error") {
                alert("Lo siento. Error " + xhr.status + ": " + xhr.statusText);
            }
        });
    });
});

