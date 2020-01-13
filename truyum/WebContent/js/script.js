function validateeditMenu()
{
    var name=document.forms["menuItemform"]["name"].value;
    if(name == ""){
        alert("Name is required");
        return false;
    }

    var NameLength=name.length;
    if(NameLength < 2 || NameLength > 65)
    {
        alert("Name should have 2 to 65 characters");
        return false;
    }
    
    
    var price=document.forms["menuItemform"]["price"].value;
    if(isNaN(price)) 
{
    alert("Price has to be a number");
    return false;
}

if(price == "")
{
    alert("Price is required");
    return false;
}

var dateOfLaunch= document.forms["menuItemform"]["dateOfLaunch"].value;
if(dateOfLaunch == "")
{
    alert("Date of Launch is required");
    return false;
}

if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/))
{
    alert("Incorrect date format(dd/mm/yyyy)");
    return false;
}

var  category= document.forms["menuItemform"]["category"].value;
if(category== "0")
{
    alert("Select one category");
    return false;
}
}


