export async function getAllUsers() {

    const response = await fetch('/api/users');
    return await response.json();
}

export async function createUser(data) {
    const response = await fetch(`/api/user`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
      })
    return await response.json();
}

export async function updateUser(userData) {
    const response = await fetch(`/api/user/${userData.id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(userData)
      })
    return await response.json();
}

export async function deleteUser(userData) {
    const response = await fetch(`/api/user/${userData.id}`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'}
      })
    return await response.json();
}