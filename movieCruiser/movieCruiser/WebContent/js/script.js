function validateForm()
{
    var title=document.forms["editMovie"]["title"].value;
    if(title == ""){
        alert("Title is required");
        return false;
    }

    var titleLength=title.length;
    if(titleLength < 2 || titleLength > 100)
    {
        alert("Title should have 2 to 100 characters");
        return false;
    }
    
    
    var gross=document.forms["editMovie"]["gross"].value;
    if(isNaN(gross)) 
{
    alert("Gross has to be a number");
    return false;
}

if(gross == "")
{
    alert("Gross is required");
    return false;
}

var dateOfLaunch= document.forms["editMovie"]["dateOfLaunch"].value;
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

var genre = document.forms["editMovie"]["genre"].value;
if(genre== "0")
{
    alert("Select one genre");
    return false;
}
}


