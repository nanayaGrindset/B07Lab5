(function () {
  "use strict";

  window.onload = function () {
    const [messages, getMessagesState, setMessages] = meact.useState([]);

    meact.useEffect((currentMessages) => {
      const messagesContainer = document.getElementById("messages");
      
      // clear all existing message comps
      messagesContainer.innerHTML = "";

      currentMessages.forEach((msg) => {
        const elmt = document.createElement("div");
        elmt.className = "row message align-items-center";
        
        // component block mapping our state
        elmt.innerHTML = `
            <div class="col-1 message-user">
              <img
                class="message-picture"
                src="media/user.png"
                alt="${msg.author}"
              />
              <div class="message-username">${msg.author}</div>
            </div>
            <div class="col-auto message-content">
              ${msg.content}
            </div>
            <div class="col-1 upvote-icon icon">${msg.upvote}</div>
            <div class="col-1 downvote-icon icon">${msg.downvote}</div>
            <div class="col-1 delete-icon icon"></div>
        `;

        // upvote event
        elmt.querySelector(".upvote-icon").addEventListener("click", function () {
          apiService.upvoteMessage(msg.messageId);
          setMessages(apiService.getMessages(0, 1000));
        });

        // downvote event
        elmt.querySelector(".downvote-icon").addEventListener("click", function () {
          apiService.downvoteMessage(msg.messageId);
          setMessages(apiService.getMessages(0, 1000));
        });

        // delete event
        elmt.querySelector(".delete-icon").addEventListener("click", function () {
          apiService.deleteMessage(msg.messageId);
          setMessages(apiService.getMessages(0, 1000));
        });

        messagesContainer.appendChild(elmt);
      });
    }, [messages]);

    // initial load, fetch existing messages from api layer
    setMessages(apiService.getMessages(0, 1000));

    document
      .getElementById("create-message-form")
      .addEventListener("submit", function (e) {
        e.preventDefault();

        const username = document.getElementById("post-username").value;
        const content = document.getElementById("post-content").value;

        // clean form
        document.getElementById("create-message-form").reset();

        apiService.addMessage(username, content);
        setMessages(apiService.getMessages(0, 1000));
      });
  };
})();