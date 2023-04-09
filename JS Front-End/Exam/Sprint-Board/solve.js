const url = 'http://localhost:3030/jsonstore/tasks/';
const loadBtn = document.getElementById('load-board-btn');
const todo = document.querySelector('#todo-section > ul');
const progress = document.querySelector('#in-progress-section > ul');
const review = document.querySelector('#code-review-section > ul');
const done = document.querySelector('#done-section > ul');
let addTask = document.getElementById('create-task-btn');

function attachEvents() {
    loadBtn.addEventListener('click', load);
    addTask.addEventListener('click', createTask);
}

function load(e) {
    if (e) {
        e.preventDefault()
    }
    todo.innerHTML = '';
    progress.innerHTML = '';
    review.innerHTML = '';
    done.innerHTML = '';
    fetch(url)
        .then(response => response.json())
        .then(data => {

            Object.values(data).forEach(item => {
                if (item.status === 'ToDo') {
                    const liElement = document.createElement('li');
                    liElement.setAttribute('class', 'task');
                    const titleElement = document.createElement('h3');
                    titleElement.textContent = `${item.title}`;
                    const pElement = document.createElement('p');
                    pElement.textContent = `${item.description}`;
                    const buttonElement = document.createElement('button');
                    buttonElement.setAttribute('id', item._id);
                    buttonElement.textContent = 'Move to In Progress';
                    liElement.appendChild(titleElement);
                    liElement.appendChild(pElement);
                    liElement.appendChild(buttonElement);
                    todo.appendChild(liElement);
                    buttonElement.addEventListener('click', move);
                } else if (item.status === 'In Progress') {
                    const liElement = document.createElement('li');
                    liElement.setAttribute('class', 'task');
                    const titleElement = document.createElement('h3');
                    titleElement.textContent = `${item.title}`;
                    const pElement = document.createElement('p');
                    pElement.textContent = `${item.description}`;
                    const buttonElement = document.createElement('button');
                    buttonElement.setAttribute('id', item._id);
                    buttonElement.textContent = 'Move to Code Review';
                    liElement.appendChild(titleElement);
                    liElement.appendChild(pElement);
                    liElement.appendChild(buttonElement);
                    progress.appendChild(liElement);
                    buttonElement.addEventListener('click', move);
                } else if (item.status === 'Code Review') {
                    const liElement = document.createElement('li');
                    liElement.setAttribute('class', 'task');
                    const titleElement = document.createElement('h3');
                    titleElement.textContent = `${item.title}`;
                    const pElement = document.createElement('p');
                    pElement.textContent = `${item.description}`;
                    const buttonElement = document.createElement('button');
                    buttonElement.setAttribute('id', item._id);
                    buttonElement.textContent = 'Move to Done';
                    liElement.appendChild(titleElement);
                    liElement.appendChild(pElement);
                    liElement.appendChild(buttonElement);
                    review.appendChild(liElement);
                    buttonElement.addEventListener('click', move);
                } else {
                    const liElement = document.createElement('li');
                    liElement.setAttribute('class', 'task');
                    const titleElement = document.createElement('h3');
                    titleElement.textContent = `${item.title}`;
                    const pElement = document.createElement('p');
                    pElement.textContent = `${item.description}`;
                    const buttonElement = document.createElement('button');
                    buttonElement.setAttribute('id', item._id);
                    buttonElement.textContent = 'Close';
                    liElement.appendChild(titleElement);
                    liElement.appendChild(pElement);
                    liElement.appendChild(buttonElement);
                    done.appendChild(liElement);
                    buttonElement.addEventListener('click', move);
                }

            });
        });
}

function move(e) {
    if (e) {
        e.preventDefault()
    }

    let currentId = e.target.id;
    if (e.target.textContent === 'Move to In Progress') {
        const headers = {
            method: "PATCH",
            body: JSON.stringify({
                status: 'In Progress'
            })
        };
        fetch(`${url}${currentId}`, headers)
            .then(() => load()
            ).catch(error => alert(error))

    } else if (e.target.textContent === 'Move to Code Review') {
        const headers = {
            method: "PATCH",
            body: JSON.stringify({
                status: 'Code Review'
            })
        };
        fetch(`${url}${currentId}`, headers)
            .then(() => load()
            ).catch(error => alert(error))
    } else if (e.target.textContent === 'Move to Done') {
        const headers = {
            method: "PATCH",
            body: JSON.stringify({
                status: 'Done'
            })
        };
        fetch(`${url}${currentId}`, headers)
            .then(() => load()
            ).catch(error => alert(error))
    } else if (e.target.textContent === 'Close') {
        fetch(`${url}${currentId}`, {
            method: "DELETE"
        })
            .then(response => {
                load()
                return response.json()
            })
            .catch(error => alert(error));
    }
}

function createTask(e) {
    if (e) {
        e.preventDefault()
    }
    let taskTitle = document.getElementById('title');
    let description = document.getElementById('description');
    if (taskTitle.value === ''
        || description.value === '') {
        return;
    }
    fetch(url, {
        method: "POST",
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            title: taskTitle.value,
            description: description.value,
            status: 'ToDo'
        })
    }).then(response => {
        if (!response.ok) {
            throw new Error('Error creating new record!');
        }
        return response.json();
    }).catch(error => alert(error));
    load();
    taskTitle.value = '';
    description.value = '';

}


attachEvents();
console.log(Number(true));