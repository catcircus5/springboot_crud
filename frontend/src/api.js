import axios from "axios"

const api = axios.create({
    baseURL: "http://localhost:8989",
    headers:{
        "Content-Type" : "application/json",
    },
})
export default api;