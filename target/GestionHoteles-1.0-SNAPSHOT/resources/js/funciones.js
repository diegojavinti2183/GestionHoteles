/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function ingresoDecimales(e)
{
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 0) || (keynum == 8) || (keynum == 9) || (keynum == 46))
        return true;
     
    return /\d/.test(String.fromCharCode(keynum));
}

function ingresoEnteros(e)
{
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 0) || (keynum == 8) || (keynum == 9))
        return true;
     
    return /\d/.test(String.fromCharCode(keynum));
}

function runScript(e) {
    //See notes about 'which' and 'key'
    if (e.keyCode == 13) {
        var tb = document.getElementById("compId");
        eval(tb.value);
        return false;
    }
}

//Funcion para convertir a mayusculas
function convertirMayusculas(id) {
     document.getElementById(id).style.cssText = ("text-transform: uppercase;");         
}
