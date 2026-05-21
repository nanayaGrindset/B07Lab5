[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/GphWpyPI)
# Javascript

### Recommended work setup

After cloning this repository, you are now ready to start working on the frontend of your application. For the first two labs only, we recommend you to work with [browser-sync](https://www.browsersync.io/) to automatically refresh your browser once any of your file is saved:

```shell
$ browser-sync start --server --no-online --files="**/*"
```

At this point, you should have an open tab in your Chrome browser with the URL: `http://localhost:3000/`. From now on, we recommend you to keep the Chrome Devtools opened (Right click context menu > Inspect Element) so you can always look at the CSS.

### Submission

All of your work should be done through your local copy of your Github repository. It is recommended that you follow good git
practices and commit/push frequently, with **logical and reasonable** git commit messages.

Either way, ensure you push before the deadline:

```shell
$ git add -A
$ git commit -m "feat: complete lab3"
$ git push
```

Make sure that your code is on Github `https://github.com/UTSC-CSCC09-Programming-on-the-Web/lab3-<your github username>`

> Note: Ensure you have generated this repo through the Github Classroom and not any other method.

## 1. Writing good javascript code

In this first part, our application _Microblog_ loads the javascript file `js/index.js`. This script defines a DOM event handler that is called when a user submits a message. So far, this code works however it contains some defects that can become bugs as our application grows. Before adding more code, we want to correct and improve that given starter code.

**Task:** First, encapsulate the code into a closure and add the `use strict` flag as show below. Test the code and correct all warnings and errors that might rise.

```js
(function () {
  "use strict";
  // your code goes here
})();
```

**Task:** Finally, let us improve the loading of Javascript:

1. For better efficiency (and whenever it is possible), it is recommended to load javascript code at the end of the body instead of loading it in the header. By doing so, the browser will start rendering the DOM before loading the script.
2. To avoid race conditions, any piece of javascript code that works with the DOM must be executed once the DOM has been fully loaded. In our application, attaching an event handler to the form might not work if the DOM is not loaded when the script executes. Therefore, we should encapsulate that piece of code with an `load` listener.

```js
window.onload = function () {
  document.addEventListener("click", function () {});
  // more
};
```

## 2. Upvote, downvote and delete

**Task:** Complete the application to implement the upvote, downvote and delete features.

## 3. Web Storage API - localStorage

You can read more about the Web Storage API [here](https://developer.mozilla.org/en-US/docs/Web/API/Web_Storage_API).

So far, any message added vanishes as soon as the page is refreshed. In the next lab, we will connect our application to a backend but for now let us experiment with localStorage. This feature is particularly useful when building a web application with an offline mode. It allows each web application to store up to 10 mb of data on the browser. This data is stored as a collection of key-value pairs:

```js
// store a value
localStorage.setItem(key, value);

// retrieve a value
localStorage.getItem(key);
```

However, localStorage is very limited and can only store base datatypes like `number`, `boolean` and `string`.
One way to go around that limitation is to store data structures such as arrays and objects as strings. To do this, we will use JSON to serialize and deserialize data.

```js
// store an object (or an array)
localStorage.setItem(key, JSON.stringify(object));

// retrieve an object (or an array)
JSON.parse(localStorage.getItem(key));
```

**Task:** Complete the application to load and store messages locally. This means that:

1. when the user opens the page page, the page loads existing messages from localStorage (if any)
2. when a new message is added, upvoted, down-voted or deleted, the data store is updated accordingly

## 4. Refactoring into a frontend API Service

In this part, we are going to refactor the code to separate it into two parts:

- **Frontend Controller** (`index.js`) controls the UI
- **Frontend API Service** (`api-service.js`) provides an API to push/pull data (to localStorage for now)

The idea is to delegate all data storage and retrieval to the **Frontend API Service**. Doing this will be useful later when we are going to work with a backend, this **Frontend API Service** will be in charge of pushing and pulling data to the server.

**Task:** Let's make a first attempt at refactoring our code by refactoring the process of creating new messages:

1. Complete the **Frontend API Service** (`api-service.js`).
   This program exposes a variable called `apiService` globally:

2. Update the **Frontend Controller** to call the API service to push and pull data

**Task:** Refactor upvote, downvote and delete following the same principles and make sure that all stored messages are displayed when the page is reloaded by the user.

## 5. Declarative programming with useEffect and useState

Instead of directly manipulating the DOM based on user events, we can use a declarative approach to describe the UI and let the "framework" handle the DOM updates. You may practice writing better declarative code by using the `useState` and `useEffect` functions in `js/meact.js`. You may also create your own "framework" if you want to.

You must call `setMessages` to update the state always, because `useEffect` does not recognize object or array mutations. Also note that the state should only reflect what is rendered on the page, and not more than that. So, if you do something like:

```
getMessages().find(m => m.id === message.id).upvotes += 1;
```

Then, the relevant `useEffect` will not be triggered, and the component will not re-render.

```js
const [messages, getMessages, setMessages] = meact.useState([]);
meact.useEffect(() => {
  // this code will run when setMessages is called
}, [messages]);

// after upvote
meact.setMessages(updatedMessageList);
```

## 6. Deploy this on Github Pages

Github Pages is a tool by Github that allows you to deploy static sites directly from your Github Repo. You can
learn more about Github Pages [here](https://pages.github.com/).

1. Head to your repository on Github, then head to `Settings > Pages`.
2. Under Source, select the `main` branch as the branch to deploy.
3. Your URL should be available under `Settings > Pages`

## Grading

- (3pts) Github Pages Deployment
- (3pts) Correct use of useState and useEffect
- (4pts) Correct coding style
