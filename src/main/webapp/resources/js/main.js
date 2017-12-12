
var toggleAdd = function() {
    var mydiv = document.getElementById('create-card');
    if (mydiv.style.display === 'block' || mydiv.style.display === '')
        mydiv.style.display = 'none';
    else
        mydiv.style.display = 'block'
}