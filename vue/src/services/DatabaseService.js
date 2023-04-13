import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
})

export default {
    //service call
    getAllClasses() {
        return http.get('/course');
    },

    getOneClass(id) {
        return http.get(`/course/${id}`);
    },

    getMyClasses(userId) {
        return http.get(`/myCourses/${userId}`);
    },

    getAllCurriculum() {
        return http.get('/curriculum');
    },

    getOneCurriculum(id) {
        return http.get(`/curriculum/${id}`);
    },

    createCurriculum(curriculum) {
        return http.post(`/curriculum`,curriculum)
    },
  
}