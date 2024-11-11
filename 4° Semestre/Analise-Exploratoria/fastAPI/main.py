from fastapi import FastAPI
from fastapi.responses import JSONResponse
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker, relationship
from sqlalchemy import Column, Integer, String, ForeignKey, DateTime

app = FastAPI()

engine = create_engine('mysql://root:root@localhost:3307/aulaDB')

SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
session = SessionLocal()

Base = declarative_base()


class Author(Base):
    __tablename__ = 'authors'
    
    id = Column(Integer, primary_key=True)
    name = Column(String)
    age = Column(Integer)
    
class Post(Base):
    __tablename__ = 'posts'
    
    id = Column(Integer, primary_key=True)
    text = Column(String)
    created = Column(DateTime)
    authorid = Column(Integer, ForeignKey('authors.id', ondelete='CASCADE'))
    
Base.metadata.create_all(bind=engine)

@app.post('/authors')
def create_author(name: str, age: int):
    status_code = 200
    
    if name is None:
        response = {'error': 'name is required'}
        status_code = 400

    if age is None:
        response = {'error': 'age is required'}
        status_code = 400
    try:
        
        if status_code == 200:
            author = Author(name=name, age=age)
            session.add(author)
            session.commit()
            response = {'id': author.id, 'name': author.name, 'age': author.age}
            status_code = 200
            
        return JSONResponse(content=response, status_code=status_code)
    except Exception as e:
        return JSONResponse(content={'error': str(e)}, status_code=500)