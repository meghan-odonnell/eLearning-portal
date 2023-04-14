import axios from 'axios';

// const http = axios.create({
//     baseURL: 'http://localhost:9000'
// })

export default {
    //service call
    getAllClasses() {
        return axios.get('/course');
    },

    getOneClass(id) {
        return axios.get(`/course/${id}`);
    },

    getMyClasses(userId) {
        return axios.get(`/myCourses/${userId}`);
    },

    getAllCurriculum() {
        return axios.get('/curriculum');
    },

    getCourseCurriculum(courseId) {
        return axios.get(`/courseCurriculum/${courseId}`);
    },

    getOneCurriculum(curriculumId) {
        return axios.get(`/singleCurriculum/${curriculumId}`);
    },

    createCurriculum(curriculum) {
        return axios.post(`/curriculum`,curriculum)
    },
  
}