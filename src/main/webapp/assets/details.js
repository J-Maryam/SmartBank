function openPopup(requestId, actionUrl) {
    // Remplacez l'ID de la demande dans la popup
    document.getElementById("requestId").innerText = requestId;

    // Mettre à jour l'action du formulaire avec l'URL passée
    document.getElementById("updateForm").action = actionUrl;

    // Afficher la popup
    document.getElementById("popup").style.display = "block";
}

function closePopup() {
    // Masquer la popup
    document.getElementById("popup").style.display = "none";
}
