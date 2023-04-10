import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:3000'
})

export default {
    //service call
    getAllFood() {
        return http.get('/daily_food_intake');
    }
}