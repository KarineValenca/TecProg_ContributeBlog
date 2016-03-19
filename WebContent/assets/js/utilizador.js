$(document).ready(function () {
    var target = document.location.hash.replace("#", "");
    if (target.length) {
        if(target=="option1"){
          showModal("title1","content1");
        }
        else if(target=="option2"){
            showModal("title2","content2");
        }
    }else{
        showModal("no title","no content");
    }

    function showModal(title,content){
        $('#myModal .modal-title').html(title);
        $('#myModal .modal-body').html(content);
        $('#myModal').modal('show');
    }
    
});

function checkForm(form)
{
  if(!form.terms.checked) {
    alert("Please indicate that you accept the Terms and Conditions");
    form.terms.focus();
    return false;
  }
  return true;
}

