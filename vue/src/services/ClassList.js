import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
})

export default {
    //service call
    getAllClasses() {
        return http.get('/course');
    }
}