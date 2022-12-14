import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }

  public listQuestionOfExam(examId:any){
    return this.http.get(`${baseUrl}pregunta/examen/todos/${examId}`);
  }

  public saveQuestion(question:any){
    return this.http.post(`${baseUrl}pregunta/`,question);
  }

  public deleteQuestion(questionId:any){
    return this.http.delete(`${baseUrl}pregunta/${questionId}`);
  }

  public updateQuestion(question:any){
    return this.http.put(`${baseUrl}pregunta/`,question);
  }

  public getQuestion(questionId:any){
    return this.http.get(`${baseUrl}pregunta/${questionId}`);
  }
  public listQuestionsOfExamnToTest(examId:any){
    return this.http.get(`${baseUrl}pregunta/examen/todos/${examId}`)
  }

  public evaluateExam(questions:any){
    return this.http.post(`${baseUrl}pregunta/evaluar-examen`,questions);
  }
}
