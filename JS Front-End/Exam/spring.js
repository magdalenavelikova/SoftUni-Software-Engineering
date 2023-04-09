function spring(input) {
    const n = Number(input[0]);
    let board = {};

    let mapOfPoints = new Map;
    mapOfPoints.set("ToDo", 0);
    mapOfPoints.set("In Progress", 0);
    mapOfPoints.set("Code Review", 0);
    mapOfPoints.set("Done", 0);

    for (let i = 1; i <= n; i++) {
        const [assignee, taskId, title, status, estimatedPoints] = input[i].split(':');
        if (!board[assignee]) board[assignee] = [];
        board[assignee].push({taskId, title, status, estimatedPoints: Number(estimatedPoints)});
        currentPoint = mapOfPoints.get(status) + Number(estimatedPoints);
        mapOfPoints.set(status, currentPoint);
    }
    for (let i = n + 1; i < input.length; i++) {
        const [command, assignee, taskId, ...args] = input[i].split(':');
        switch (command) {
            case 'Add New':
                const [title, status, estimatedPoints] = args;
                const task = {taskId, title, status, estimatedPoints: Number(estimatedPoints)};
                if (!board[assignee]) {
                    console.log(`Assignee ${assignee} does not exist on the board!`);
                } else {
                    board[assignee].push(task);
                    let currentPoint = Number(mapOfPoints.get(task.status)) + Number(estimatedPoints);
                    mapOfPoints.set(task.status, currentPoint);
                }
                break;

            case 'Change Status':
                const [newStatus] = args;
                if (!board[assignee]) {
                    console.log(`Assignee ${assignee} does not exist on the board!`);
                } else {
                    const task = board[assignee].find(t => t.taskId === taskId);
                    if (!task) {
                        console.log(`Task with ID ${taskId} does not exist for ${assignee}!`);
                    } else {
                        let currentPoint = Number(mapOfPoints.get(task.status)) - task.estimatedPoints;
                        mapOfPoints.set(task.status, currentPoint);
                        task.status = newStatus;
                        currentPoint = mapOfPoints.get(task.status) + task.estimatedPoints;
                        mapOfPoints.set(task.status, currentPoint);
                    }
                }
                break;

            case 'Remove Task':
                const index = parseInt(taskId);
                if (!board[assignee]) {
                    console.log(`Assignee ${assignee} does not exist on the board!`);
                } else if (index < 0 || index >= board[assignee].length) {
                    console.log(`Index is out of range!`);
                } else {
                    const task = board[assignee][index];
                    let currentPoint =Number(mapOfPoints.get(task.status)) - task.estimatedPoints;
                    mapOfPoints.set(task.status, currentPoint);
                    board[assignee].splice(index, 1);
                }
                break;
        }
    }

    console.log(`ToDo: ${mapOfPoints.get("ToDo")}pts`);
    console.log(`In Progress: ${mapOfPoints.get("In Progress")}pts`);
    console.log(`Code Review: ${mapOfPoints.get("Code Review")}pts`);
    console.log(`Done Points: ${mapOfPoints.get("Done")}pts`);
    if (mapOfPoints.get("Done") >= mapOfPoints.get("ToDo") + mapOfPoints.get("In Progress") + mapOfPoints.get("Code Review")) {
        console.log('Sprint was successful!');

    } else {
        console.log('Sprint was unsuccessful...');
    }

}

spring(
    [
        '4',
        'Kiril:BOP-1213:Fix Typo:Done:1',
        'Peter:BOP-1214:New Products Page:In Progress:2',
        'Mariya:BOP-1215:Setup Routing:ToDo:8',
        'Georgi:BOP-1216:Add Business Card:Code Review:3',
        'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
        'Change Status:Georgi:BOP-1216:Done',
        'Change Status:Will:BOP-1212:In Progress',
        'Remove Task:Georgi:3',
        'Change Status:Mariya:BOP-1215:Done',

]);