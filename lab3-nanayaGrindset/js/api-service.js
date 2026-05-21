let apiService = (function () {
  "use strict";
  
  let module = {};

  /*  
    ******* Data types *******
    Message:
      Attributes:
        - (string) messageId 
        - (string) author
        - (string) content
        - (number) upvote
        - (number) downvote 
  */

  // pull data from localStorage
  function getStoredMessages() {
    const data = localStorage.getItem("messages");
    return data ? JSON.parse(data) : [];
  }

  // push data to localStorage
  function saveStoredMessages(messages) {
    localStorage.setItem("messages", JSON.stringify(messages));
  }

  /**
   * Add a message
   * @param {string} author: the author of this message
   * @param {string} content: message content
   */
  module.addMessage = function (author, content) {
    const messages = getStoredMessages();
    const newMessage = {
      // robust unique message id
      messageId: Date.now().toString() + Math.random().toString(36).substring(2, 9),
      author: author,
      content: content,
      upvote: 0,
      downvote: 0,
    };
    messages.push(newMessage);
    saveStoredMessages(messages);
    return newMessage;
  };

  /**
   * Delete a message
   * @param {*} messageId message to be deleted
   */
  module.deleteMessage = function (messageId) {
    let messages = getStoredMessages();
    // Filter out the message to delete
    messages = messages.filter((msg) => msg.messageId !== messageId);
    saveStoredMessages(messages);
  };

  /**
   * Upvote a message
   * @param {*} messageId message to be upvoted
   */
  module.upvoteMessage = function (messageId) {
    const messages = getStoredMessages();
    const message = messages.find((msg) => msg.messageId === messageId);
    if (message) {
      message.upvote += 1;
      saveStoredMessages(messages);
    }
  };

  /**
   * Downvote a message
   * @param {*} messageId message to be downvoted
   */
  module.downvoteMessage = function (messageId) {
    const messages = getStoredMessages();
    const message = messages.find((msg) => msg.messageId === messageId);
    if (message) {
      message.downvote += 1;
      saveStoredMessages(messages);
    }
  };

  /**
   * Return the latest messages using pagination.
   *
   * page=0 returns the first 5 messages, page=1 returns the next 5 messages, etc.
   *
   * @param {number} page: the page you are currently on
   * @param {number} limit: how many messages to retrieve per page
   */
  module.getMessages = function (page = 0, limit = 5) {
    const messages = getStoredMessages();
    // reverse chronological order 
    const latestMessages = messages.slice().reverse();
    return latestMessages.slice(page * limit, page * limit + limit);
  };

  return module;
})();