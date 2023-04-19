import axios from 'axios';

export default {
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

    createCourse(course) {
        return axios.post(`/course`,course);
    },

    createCurriculum(curriculum) {
        return axios.post(`/curriculum`,curriculum)
    },
    
    createAssignment(assignment) {
        return axios.post(`/assignment`,assignment)
    },
    getHomework() {
        return axios.get('/assignment')
    },
    getMyAssignments(studentId) {
        return axios.get(`/studentAssignments/${studentId}`)
    },   
    getOneAssignment(assignmentId){
        return axios.get(`/assignment/${assignmentId}`);
    },
    submitGrade(assignmentId, assignment){
        return axios.put(`/assignment/${assignmentId}`,assignment);
    },
    submitHomework(studentId, curriculumId, assignment){
        return axios.put(`/assignment/${studentId}/${curriculumId}`, assignment);
    }

}