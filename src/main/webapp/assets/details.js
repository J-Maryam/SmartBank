function openPopup(requestId, actionUrl) {
    // Remplacez l'ID de la demande dans la popup
    document.getElementById(`requestId-${requestId}`).innerText = requestId;

    // Mettre à jour l'action du formulaire avec l'URL passée
    document.getElementById(`updateForm-${requestId}`).action = actionUrl;

    // Afficher la popup spécifique à cette demande
    document.getElementById(`popup-${requestId}`).style.display = "block";
}

function closePopup(requestId) {
    // Masquer la popup spécifique à cette demande
    document.getElementById(`popup-${requestId}`).style.display = "none";
}
