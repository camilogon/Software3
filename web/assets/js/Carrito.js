/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function()
{
   $('tr #delete').click(function(e)
   {
       e.preventDefault();
       var elemento=$(this);
       var idArticulo=elemento.parent().find("#idArticulo").text();
       //alert(idArticulo);
       $.ajax({
           url:'Borrar',
           type: 'post',
           data:{idArticulo:idArticulo}
           
       });
       elemento.parent().parent().remove();
       var elementosTabla=$('#tabla > tbody > tr');
       //alert(elementosTabla.length);
       if(elementosTabla.length<1)
       {
           $('#divTabla').append("<span>No hay articulos en el carrito</span>  ");
       }
   });
});

